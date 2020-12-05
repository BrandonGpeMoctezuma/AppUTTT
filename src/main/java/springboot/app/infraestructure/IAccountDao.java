package springboot.app.infraestructure;

import java.util.List;

import springboot.app.model.LoginAcconunt;
import springboot.app.model.ProductRegister;
import springboot.app.model.RegistrerAccount;

public interface IAccountDao {
	
	public void save(LoginAcconunt account);
	public boolean AccountValidate(LoginAcconunt account);
	public void saveRegister(RegistrerAccount register);
	public List<RegistrerAccount> findAll();
	public RegistrerAccount findById(Long id);
	
	
	public void saveRegisterPro(ProductRegister register);
	public List<ProductRegister> findAllPro();
	public ProductRegister findByIdPro(Long id);
	public void delete(Long id);
}
