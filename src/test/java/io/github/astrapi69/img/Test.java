package io.github.astrapi69.img;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import com.googlecode.pngtastic.core.PngImage;
import com.googlecode.pngtastic.core.PngOptimizer;

/**
 * Example pngtastic image optimization usage from java
 */
public class Test
{

	public static void main(String[] args) throws Exception
	{
		// load png image from a file
		final InputStream in = new BufferedInputStream(new FileInputStream("/input.png"));
		final PngImage image = new PngImage(in);

		// optimize
		final PngOptimizer optimizer = new PngOptimizer();
		final PngImage optimizedImage = optimizer.optimize(image);

		// export the optimized image to a new file
		final ByteArrayOutputStream optimizedBytes = new ByteArrayOutputStream();
		optimizedImage.writeDataOutputStream(optimizedBytes);
		optimizedImage.export("/output.png", optimizedBytes.toByteArray());
	}

}