package photo;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

import static photo.PhotoUtils.DateForamt.DATE_FORMAT_V3;

/**
 * @author: Crady
 * date: 2022/10/5 14:52
 * desc:
 **/
public class PhotoUtils {

    static enum DateForamt {
        // YYYYMMddHHmmss
        DATE_FORMAT_V1("yyyyMMddHHmmss"),
        // YYYY-MM-dd HH:mm:ss
        DATE_FORMAT_V2("yyyy-MM-dd HH:mm:ss"),
        // YYYY:MM:dd HH:mm:ss
        DATE_FORMAT_V3("yyyy:MM:dd HH:mm:ss");

        private String value;
        DateForamt(String value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        File file = new File("/Users/zhouming/Downloads/IMG_20161122_195235.jpg");
//        System.out.println(getPhotoTime(file ,DateForamt.DATE_FORMAT_V1));
        getPhotoAttributes(file);
    }

    /**
     * 获取照片的拍摄时间
     * @param file  照片文件
     * @param foramt 时间格式
     * @return 时间字符串
     */
    public static String getPhotoTime(File file, DateForamt foramt) {
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(file);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    Tag tag = tags.next();
                    if ("Date/Time".equalsIgnoreCase(tag.getTagName())) {
                        if (Objects.nonNull(foramt)){
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_V3.value);
                            SimpleDateFormat sdf = new SimpleDateFormat(foramt.value);
                            Date date = simpleDateFormat.parse(tag.getDescription());
                            return sdf.format(date);
                        }
                        return tag.getDescription();
                    }
                }
            }
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取照片的所有属性
     * @param file
     * @return
     */
    public static String getPhotoAttributes(File file) {
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(file);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    Tag tag = tags.next();
                    System.out.println(tag);
                }
            }
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

