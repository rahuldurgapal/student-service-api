package com.test.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;


@SpringBootTest
@AutoConfigureMockMvc
class StudentserviceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	@Test
	void testUploadFile() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "students.csv",
                MediaType.TEXT_PLAIN_VALUE,
                "roll number,student name,science,maths,english,computer,Eligible\n100101,Rahul Durgapal,87,89,76,94,ToBeChecked".getBytes()
        );

		mockMvc.perform(MockMvcRequestBuilders.multipart("/students/upload")
		.file(file))
		.andReturn();


        }


	@Test
	void testFindStudentByRollNo() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("students/search/100101"))
		.andReturn();
	}

	@Test
	void testUpdateCriteria() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/students/criteria")
		       .contentType(MediaType.APPLICATION_JSON)
			   .content("{\"science\": 80, \"maths\": 85, \"english\": 70, \"computer\": 90}"))
			   .andReturn();
			}
}