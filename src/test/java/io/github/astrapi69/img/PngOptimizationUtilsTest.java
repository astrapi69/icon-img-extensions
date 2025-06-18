package io.github.astrapi69.img;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.file.search.PathFinder;

class PngOptimizationUtilsTest
{

	private File inputFile;
	private File outputFile;

	@BeforeEach
	void setUp() throws IOException
	{
		File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");
		File xmas = new File(imgDir, "xmas");
		inputFile = new File(xmas, "bell.png");

		outputFile = new File(inputFile.getParent(), "optimized.png");
	}

	@AfterEach
	void tearDown()
	{
		if (outputFile != null)
			outputFile.delete();
	}

	@Test
	void testOptimizeFile() throws IOException
	{
		assertTrue(inputFile.exists());

		PngOptimizationUtils.optimizeFile(inputFile, outputFile);

		assertTrue(outputFile.exists());
		assertTrue(outputFile.length() > 0, "Optimized file should not be empty");

		long originalSize = inputFile.length();
		long optimizedSize = outputFile.length();

		System.out.printf("Original size: %d bytes%n", originalSize);
		System.out.printf("Optimized size: %d bytes%n", optimizedSize);

		assertTrue(optimizedSize <= originalSize,
			"Optimized image should not be larger than original");
	}

	@Test
	void testOptimizeToBytes() throws IOException
	{
		try (InputStream is = Files.newInputStream(inputFile.toPath()))
		{
			byte[] optimizedBytes = PngOptimizationUtils.optimizeToBytes(is);
			assertNotNull(optimizedBytes);
			assertTrue(optimizedBytes.length > 0);
		}
	}

	@Test
	void testOptimizeFileByPath() throws IOException
	{
		PngOptimizationUtils.optimizeFile(inputFile.getAbsolutePath(),
			outputFile.getAbsolutePath());
		assertTrue(outputFile.exists());
	}
}
