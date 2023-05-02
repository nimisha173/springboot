package com.UST.State.controller;

import com.UST.State.entity.District;
import com.UST.State.service.DistrictService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DistrictController.class)
class DistrictControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistrictService mockDistrictService;

    @Test
    void testGetDistrictsByState() throws Exception {
        // Setup
        // Configure DistrictService.getDistrictsByState(...).
        final District district = new District();
        final List<District> districts = List.of(district);
        when(mockDistrictService.getDistrictsByState("state")).thenReturn(districts);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/district/state")
                        .param("state", "state")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetDistrictsByState_DistrictServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockDistrictService.getDistrictsByState("state")).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/district/state")
                        .param("state", "state")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
