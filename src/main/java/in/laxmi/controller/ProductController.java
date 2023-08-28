package in.laxmi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.laxmi.entity.Product;
import in.laxmi.repo.ProductRepository;
import lombok.Getter;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping("/delete")
	public String delete(@RequestParam("pid") Integer pid, Model model) {
		repo.deleteById(pid);
		model.addAttribute("msg", "Deleted Record");
		model.addAttribute("products", repo.findAll());
		return "data";

	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("pid") Integer pid, Model model) {
		Optional<Product> findById = repo.findById(pid);
          if(findById.isPresent()) {
        	  Product product = findById.get();
        	  model.addAttribute("product", product);
		   }
		return "index";

	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {
		List<Product> list = repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}

	@PostMapping("/product")
	public String saveProduct(@Validated @ModelAttribute("product") Product p,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "index";
		}
		
		p = repo.save(p);

		if (p.getPid() != null) {
			model.addAttribute("msg", "Product Saved");
		}
		return "index";
	}

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

}
