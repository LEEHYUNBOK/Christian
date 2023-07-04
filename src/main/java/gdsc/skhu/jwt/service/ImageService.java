package gdsc.skhu.jwt.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${bucket.name}")
    private String bucketName;

    private final Storage storage;

    public String insertImage(MultipartFile image, String whoIsIt, String whatIsJob) {
        log.info("updateMemberChallengeInfo = ");
        // !!!!!!!!!!!이미지 업로드 관련 부분!!!!!!!!!!!!!!!
        String imageName = whatIsJob+"/" + whoIsIt + ".jpg"; // Google Cloud Storage에 저장될 파일 이름
        String ext = image.getContentType(); // 파일의 형식 ex) JPG
        log.info("UUID" + imageName + " " + ext);

//         Cloud에 이미지 업로드
        try {
            BlobInfo blobInfo = storage.create(
                    BlobInfo.newBuilder(bucketName, imageName)
                            .setContentType(ext)
                            .build(),
                    image.getInputStream()
            );
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return "https://storage.googleapis.com/"+bucketName+"/"+whatIsJob+"/" + whoIsIt + ".jpg";
    }


    public void deleteImage(String filePath) {
        Blob blob = storage.get(bucketName, filePath);
        if (blob == null) {
            System.out.println("The object " + filePath + " wasn't found in " + bucketName);
            return;
        }

        // Optional: set a generation-match precondition to avoid potential race
        // conditions and data corruptions. The request to upload returns a 412 error if
        // the object's generation number does not match your precondition.
        Storage.BlobSourceOption precondition =
                Storage.BlobSourceOption.generationMatch(blob.getGeneration());

        storage.delete(bucketName, filePath, precondition);

        System.out.println("Object " + filePath + " was deleted from " + bucketName);
    }
}
