package uzpdp.belissimopizza.Servise;

//Asilbek Fayzullayev 10.04.2022 12:41   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uzpdp.belissimopizza.model.Attachment;
import uzpdp.belissimopizza.model.AttachmentContent;
import uzpdp.belissimopizza.payload.ApiResponse;
import uzpdp.belissimopizza.repository.AttachmentContentRepository;
import uzpdp.belissimopizza.repository.AttachmentRepository;

import java.io.IOException;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;



    public ApiResponse fileUpload(MultipartFile file) {
        try {
            Attachment attachment = attachmentRepository.save(new Attachment(file.getOriginalFilename(), file.getSize(), file.getContentType()));
            attachmentContentRepository.save(new AttachmentContent(file.getBytes(), attachment));
            return new ApiResponse("Successfully uploaded", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }
}
