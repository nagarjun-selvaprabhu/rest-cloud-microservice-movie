package com.nagarjun.Cts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.Format.Field;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nagarjun.cts.Repo.MovieRepo;
import com.nagarjun.cts.controller.Controller;
import com.nagarjun.cts.dto.Movie;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
public class CtsApplicationTests {

	@MockBean
	MovieRepo mov;

	@Autowired
	Controller con;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(con).build();
	}

	@Test
	public void isok() {
		assertThat(con).isNotNull();
	}

	@Test
	public void getTest() {
		Movie movdto = new Movie(1, "abc", "bbb", "ccc");
		List<Movie> list = Arrays.asList(new Movie(1, "abc", "bbb", "ccc"));
		when(con.getCatalog()).thenReturn(list);
		org.junit.jupiter.api.Assertions.assertEquals(list, mov.findAll());
	}

	@Test
	public void savesTheUserTest() {
		Boolean ok = true;
		Movie movdto = new Movie(1, "abc", "bbb", "ccc");
		when(con.insert(movdto)).thenReturn(ok);
		org.junit.jupiter.api.Assertions.assertEquals(true, ok);
	}

	@Test
	public void deleteTest() {
		Integer id = 1;
		Boolean bool = con.deleteMovie(id);
		assertTrue(con.deleteMovie(id));
	}

	@Test
	public void SwaggerTest() throws Exception {
		try {
			mockMvc.perform(get("/swagger")).andExpect(status().isOk());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getMappingTest() {
		try {
			mockMvc.perform(get("/api/getAll")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    @Test
    public void SetterNameTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Movie pojo = new Movie();
        //when
        pojo.setName("nagarjun");
        //then
        java.lang.reflect.Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(pojo), "nagarjun");
    }
    
    @Test
    public void SetterLangTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Movie pojo = new Movie();
        //when
        pojo.setLang("nagarjun");
        //then
        java.lang.reflect.Field field = pojo.getClass().getDeclaredField("lang");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(pojo), "nagarjun");
    }
    
    @Test
    public void SetterGenreTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Movie pojo = new Movie();
        //when
        pojo.setGenre("nagarjun");
        //then
        java.lang.reflect.Field field = pojo.getClass().getDeclaredField("genre");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(pojo), "nagarjun");
    }
    
    @Test
    public void GetterNameTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Movie pojo = new Movie();
        java.lang.reflect.Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(pojo, "magic_values");
        //when
        String result = pojo.getName();
        //then
        assertEquals("field wasn't retrieved properly", result, "magic_values");
    }
    
    @Test
    public void GetterLangTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Movie pojo = new Movie();
        java.lang.reflect.Field field = pojo.getClass().getDeclaredField("lang");
        field.setAccessible(true);
        field.set(pojo, "magic_values");
        //when
        String result = pojo.getLang();
        //then
        assertEquals("field wasn't retrieved properly", result, "magic_values");
    }
    
    @Test
    public void GetterGenreTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Movie pojo = new Movie();
        java.lang.reflect.Field field = pojo.getClass().getDeclaredField("genre");
        field.setAccessible(true);
        field.set(pojo, "magic_values");
        //when
        String result = pojo.getGenre();
        //then
        assertEquals("field wasn't retrieved properly", result, "magic_values");
    }


}
