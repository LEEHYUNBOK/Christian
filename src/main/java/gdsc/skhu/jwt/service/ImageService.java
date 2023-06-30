package gdsc.skhu.jwt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

//    @Value("${bucket.name}")
//    private String bucketName;

//    private final Storage storage;

    public void insertImage(MultipartFile image, String whoIsIt, String whatIsJob) {
        log.info("updateMemberChallengeInfo = ");
        // !!!!!!!!!!!이미지 업로드 관련 부분!!!!!!!!!!!!!!!
        String imageName = whatIsJob+"/" + whoIsIt + ".jpg"; // Google Cloud Storage에 저장될 파일 이름
        String ext = image.getContentType(); // 파일의 형식 ex) JPG
        log.info("UUID" + imageName + " " + ext);

        // Cloud에 이미지 업로드
//        BlobInfo blobInfo = storage.create(
//                BlobInfo.newBuilder(bucketName, imageName)
//                        .setContentType(ext)
//                        .build(),
//                image.getInputStream()
//        );

    }
}
