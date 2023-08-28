package in.laxmi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.laxmi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
