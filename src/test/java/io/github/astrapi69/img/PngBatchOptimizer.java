package io.github.astrapi69.img;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Utility class to optimize all PNG files in a directory and package them into a ZIP archive
 */
public class PngBatchOptimizer
{

	/**
	 * Optimizes all PNG files in the given directory (recursively) and zips them into one archive
	 *
	 * @param inputDir
	 *            the directory containing PNGs
	 * @param zipFile
	 *            the output ZIP file
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static void optimizeAndZipAllPngs(Path inputDir, Path zipFile) throws IOException
	{
		if (!Files.isDirectory(inputDir))
		{
			throw new IllegalArgumentException("Input path is not a directory: " + inputDir);
		}

		Path tempDir = Files.createTempDirectory("optimized-pngs");

		try
		{
			// Walk the directory and optimize all PNGs
			Files.walk(inputDir).filter(p -> p.toString().toLowerCase().endsWith(".png"))
				.forEach(png -> {
					try
					{
						Path relative = inputDir.relativize(png);
						Path target = tempDir.resolve(relative);
						Files.createDirectories(target.getParent());
						PngOptimizationUtils.optimizeFile(png.toFile(), target.toFile());
					}
					catch (IOException e)
					{
						throw new UncheckedIOException("Error optimizing: " + png, e);
					}
				});

			// Zip the optimized files
			zipDirectory(tempDir, zipFile);
		}
		finally
		{
			deleteRecursively(tempDir);
		}
	}

	/**
	 * Compresses the given directory into a ZIP file
	 *
	 * @param sourceDir
	 *            the root of the directory to zip
	 * @param zipFilePath
	 *            the path of the resulting ZIP file
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	private static void zipDirectory(Path sourceDir, Path zipFilePath) throws IOException
	{
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath.toFile())))
		{
			Files.walk(sourceDir).filter(Files::isRegularFile).forEach(file -> {
				try
				{
					Path relativePath = sourceDir.relativize(file);
					ZipEntry zipEntry = new ZipEntry(relativePath.toString().replace("\\", "/"));
					zos.putNextEntry(zipEntry);
					Files.copy(file, zos);
					zos.closeEntry();
				}
				catch (IOException e)
				{
					throw new UncheckedIOException("Failed to zip file: " + file, e);
				}
			});
		}
	}

	/**
	 * Recursively deletes a directory and all its contents
	 *
	 * @param path
	 *            the path to delete
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	private static void deleteRecursively(Path path) throws IOException
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
