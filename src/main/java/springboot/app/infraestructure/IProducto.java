package springboot.app.infraestructure;

import org.springframework.data.repository.CrudRepository;

import springboot.app.model.ProductRegister;

public interface IProducto extends CrudRepository<ProductRegister, Long>{

}
