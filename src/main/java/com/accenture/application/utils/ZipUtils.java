package com.accenture.application.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

public class ZipUtils {

    private static Logger logger = Logger.getLogger(ZipUtils.class);


    public File zipFile(String zipOutName, File input, String zippedName) throws FileNotFoundException, IOException {
        File zip = new File(zipOutName);
        byte[] buf = new byte[1024];
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
        FileInputStream in = new FileInputStream(input);
        Arrays.fill(buf, Byte.valueOf("0"));
        out.putNextEntry(new ZipEntry(zippedName));
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.closeEntry();
        in.close();
        out.close();
        return zip;
    }

    public File zipFiles(String zipOutName, Collection<String> zipEntries) throws FileNotFoundException, IOException {
        File zip = new File(zipOutName);
        byte[] buf = new byte[1024];
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
        Iterator<String> entries = zipEntries.iterator();
        while (entries.hasNext()) {
            String zipEntry = entries.next();
            FileInputStream in = new FileInputStream(zipEntry);
            Arrays.fill(buf, Byte.valueOf("0"));
            out.putNextEntry(new ZipEntry(new File(zipEntry).getName()));
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();

        }

        out.close();

        return zip;
    }

    public File zipFiles(File zipOut, Collection<File> zipEntries) throws FileNotFoundException, IOException {
        byte[] buf = new byte[1024];
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipOut));
        Iterator<File> entries = zipEntries.iterator();
        while (entries.hasNext()) {
            File zipEntry = entries.next();
            FileInputStream in = new FileInputStream(zipEntry);
            Arrays.fill(buf, Byte.valueOf("0"));
            out.putNextEntry(new ZipEntry(zipEntry.getName()));
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();

        }

        out.close();

        return zipOut;
    }

    public File unzipFile(String zipName, File fileOut)
            throws FileNotFoundException {

        BufferedOutputStream out = null;
        ZipInputStream in = null;

        try {

            in = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipName)));
            @SuppressWarnings("unused")
			ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[1024];

                out = new BufferedOutputStream(new FileOutputStream(fileOut.getAbsolutePath()), 1024);
                while ((count = in.read(data, 0, 1024)) != -1) {
                    out.write(data, 0, count);
                }
                out.flush();
                IOUtils.closeQuietly(out, true);
            }

            return fileOut;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            IOUtils.closeQuietly(out, true);
            IOUtils.closeQuietly(in, true);
        }
    }

    public File unzipFile(InputStream stream, File fileOut)
            throws FileNotFoundException {

        BufferedOutputStream out = null;
        ZipInputStream in = null;

        try {

            in = new ZipInputStream(new BufferedInputStream(stream));
            @SuppressWarnings("unused")
			ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[1024];

                out = new BufferedOutputStream(new FileOutputStream(fileOut.getAbsolutePath()), 1024);
                while ((count = in.read(data, 0, 1024)) != -1) {
                    out.write(data, 0, count);
                }
                out.flush();
                IOUtils.closeQuietly(out, true);
            }

            return fileOut;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            IOUtils.closeQuietly(out, true);
            IOUtils.closeQuietly(in, true);
        }
    }

    public void unzipFilesToDir(String zipName, File outputDir)
            throws FileNotFoundException {

        BufferedOutputStream out = null;
        ZipInputStream in = null;

        try {

            in = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipName)));
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[1024];

                out = new BufferedOutputStream(new FileOutputStream(outputDir.getPath() + "/" + entry.getName()), 1024);
                while ((count = in.read(data, 0, 1024)) != -1) {
                    out.write(data, 0, count);
                }
                out.flush();
                IOUtils.closeQuietly(out, true);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(out, true);
            IOUtils.closeQuietly(in, true);
        }
    }
}
