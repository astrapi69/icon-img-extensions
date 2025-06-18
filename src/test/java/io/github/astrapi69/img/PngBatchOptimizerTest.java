package io.github.astrapi69.img;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link PngBatchOptimizer}
 */
class PngBatchOptimizerTest
{

	/** Temporary input directory with test PNGs */
	private Path testInputDir;

	/** Path to the output ZIP file */
	private Path outputZip;

	/**
	 * Sets up the test by creating a temporary input directory and test files
	 *
	 * @throws IOException
	 *             if I/O error occurs
	 */
	@BeforeEach
	void setUp() throws IOException
	{
		testInputDir = Files.createTempDirectory("png-batch-test");
		outputZip = Files.createTempFile("optimized", ".zip");

		// Create subfolders and copy test images
		Path subfolder = testInputDir.resolve("subdir");
		Files.createDirectories(subfolder);

		copyTestPng("/test.png", testInputDir.resolve("image1.png"));
		copyTestPng("/test.png", subfolder.resolve("image2.png"));
	}

	/**
	 * Cleans up temporary files and folders after each test
	 *
	 * @throws IOException
	 *             if I/O error occurs
	 */
	@AfterEach
	void tearDown() throws IOException
	{
		deleteRecursively(testInputDir);
		Files.deleteIfExists(outputZip);
	}

	/**
	 * Verifies that all PNGs in the input directory are optimized and zipped correctly
	 *
	 * @throws IOException
	 *             if I/O error occurs during processing
	 */
	@Test
	void testOptimizeAndZipAllPngs() throws IOException
	{
		PngBatchOptimizer.optimizeAndZipAllPngs(testInputDir, outputZip);

		assertTrue(Files.exists(outputZip), "ZIP file should be created");
		assertTrue(Files.size(outputZip) > 0, "ZIP file should not be empty");

		try (ZipFile zipFile = new ZipFile(outputZip.toFile()))
		{
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			int count = 0;
			while (entries.hasMoreElements())
			{
				ZipEntry entry = entries.nextElement();
				assertFalse(entry.isDirectory());
				assertTrue(entry.getName().endsWith(".png"), "Only PNGs expected in ZIP");
				count++;
			}
			assertEquals(2, count, "Should contain exactly two PNG files");
		}
	}

	/**
	 * Copies a PNG resource from the classpath to the given file location
	 *
	 * @param resourcePath
	 *            the resource path of the PNG in test resources
	 * @param target
	 *            the file path where the resource should be copied
	 * @throws IOException
	 *             if I/O error occurs
	 */
	private void copyTestPng(String resourcePath, Path target) throws IOException
	{
		try (InputStream is = getClass().getResourceAsStream(resourcePath))
		{
			assertNotNull(is, "Test PNG resource not found: " + resourcePath);
			Files.copy(is, target, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	/**
	 * Deletes a directory and all its contents recursively
	 *
	 * @param path
	 *            the directory to delete
	 * @throws IOException
	 *             if I/O error occurs
	 */
	private void deleteRecursively(Path path) throws IOException
	{
		if (Files.notExists(path))
			return;
		Files.walk(path).sorted((a, b) -> b.compareTo(a)) // Delete children first
			.forEach(p -> {
				try
				{
					Files.delete(p);
				}
				catch (IOException ignored)
				{
				}
			});
	}
}
