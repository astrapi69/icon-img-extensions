package io.github.astrapi69.img;

import java.io.*;

import com.googlecode.pngtastic.core.PngImage;
import com.googlecode.pngtastic.core.PngOptimizer;

/**
 * Utility class for PNG optimization using pngtastic
 */
public class PngOptimizationUtils
{

	/**
	 * Optimizes a PNG image from an input file and writes the result to an output file
	 *
	 * @param inputFile
	 *            the input PNG file
	 * @param outputFile
	 *            the file where the optimized image will be written
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static void optimizeFile(File inputFile, File outputFile) throws IOException
	{
		try (InputStream in = new BufferedInputStream(new FileInputStream(inputFile)))
		{
			PngImage image = new PngImage(in);
			PngImage optimized = new PngOptimizer().optimize(image);

			try (ByteArrayOutputStream baos = new ByteArrayOutputStream())
			{
				optimized.writeDataOutputStream(baos);
				outputFile.getParentFile().mkdirs(); // Ensure the output directory exists
				optimized.export(outputFile.getAbsolutePath(), baos.toByteArray());
			}
		}
	}

	/**
	 * Optimizes a PNG image from an InputStream and returns a byte array of the result
	 *
	 * @param in
	 *            the input stream with PNG data
	 * @return the optimized image as byte array
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static byte[] optimizeToBytes(InputStream in) throws IOException
	{
		PngImage image = new PngImage(in);
		PngImage optimized = new PngOptimizer().optimize(image);

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream())
		{
			optimized.writeDataOutputStream(baos);
			return baos.toByteArray();
		}
	}

	/**
	 * Optimizes a PNG from one path to another
	 *
	 * @param inputPath
	 *            absolute or relative path to input PNG
	 * @param outputPath
	 *            absolute or relative path to output PNG
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static void optimizeFile(String inputPath, String outputPath) throws IOException
	{
		optimizeFile(new File(inputPath), new File(outputPath));
	}
}
