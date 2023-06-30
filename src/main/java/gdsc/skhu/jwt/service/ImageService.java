package gdsc.skhu.jwt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

//    @Value("${bucket.name}")
//    private String bucketName;

//    private final Storage storage;

    public String insertImage(MultipartFile image, String whoIsIt, String whatIsJob) {
        log.info("updateMemberChallengeInfo = ");
        // !!!!!!!!!!!이미지 업로드 관련 부분!!!!!!!!!!!!!!!
        String imageName = whatIsJob+"/" + whoIsIt + ".jpg"; // Google Cloud Storage에 저장될 파일 이름
        String ext = image.getContentType(); // 파일의 형식 ex) JPG
        log.info("UUID" + imageName + " " + ext);

        // Cloud에 이미지 업로드
//        try {
//            BlobInfo blobInfo = storage.create(
//                    BlobInfo.newBuilder(bucketName, imageName)
//                            .setContentType(ext)
//                            .build(),
//                    image.getInputStream()
//            );
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
        return "https://storage.googleapis.com/"+"버킷이름/"+whatIsJob+"/" + whoIsIt + ".jpg";
    }


    public void deleteImage(String filePath) {
//        boolean isDelete = storage.delete(BlobId.of(bucketName, filePath));
//
//        if (!isDelete) {
//            throw new GCSFIleNotFoundException();
//        }
    }
}
