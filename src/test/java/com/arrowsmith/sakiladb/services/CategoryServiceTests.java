package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.base.ServiceTests;
import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.entities.Category;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(Category.class)
class CategoryServiceTests extends ServiceTests<Category> {

	@Mock
	CategoryController categoryController;

	@Test
	void contextLoads() {

	}


	@Test
	void canCreateCategory() {
		Category category = new Category();
		//categoryController.saveCategory(category);
	}


	@Override
	public void canCreate() {

	}

	@Override
	public void canDelete() {

	}

	@Override
	public void canUpdate() {

	}

	@Override
	public void canRead() {

	}

	@Override
	public Category getBasic() {
		return null;
	}

	@Override
	protected void addAdditional(Category entity) {

	}
}
