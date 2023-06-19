package gdsc.skhu.jwt.service;

import gdsc.skhu.jwt.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void save(){

    }
}
