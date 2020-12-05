	package springboot.app.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import springboot.app.infraestructure.IAccountDao;
import springboot.app.infraestructure.IProducto;
import springboot.app.model.LoginAcconunt;
import springboot.app.model.ProductRegister;
import springboot.app.model.RegistrerAccount;

@Repository
public class AccountDaoImpl implements IAccountDao{
	
	@Autowired
	private IProducto data;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(LoginAcconunt account) {
		em.persist(account);
	}
	
	@Transactional(readOnly=true)
	public boolean AccountValidate(LoginAcconunt account)
	{
		boolean respuesta = false;
		try 
		{
			LoginAcconunt result = (LoginAcconunt) em.createQuery("SELECT e FROM LoginAccount e WHERE e.email=?1 and e.password = ?2")
					.setParameter(1, account.getEmail())
					.setParameter(2, account.getPassword()).getSingleResult();
			if(result != null)
			{
				respuesta = true;
			}
		}
		catch(Exception ex)
		{
			
		}
		return respuesta;
	}
	
	@Transactional
	public void saveRegister(RegistrerAccount register) {
		if(register.getId() != null && register.getId()>0) 
		{
			em.merge(register);
		}
		else 
		{
			em.persist(register);
		}
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<RegistrerAccount> findAll()
	{
		return em.createQuery("from RegistrerAccount").getResultList();
		
	}
	
	public String listar(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public RegistrerAccount findById(Long id) {
		return em.find(RegistrerAccount.class, id);
	}
	
	
	

	@Transactional
	public void saveRegisterPro(ProductRegister register) 
	{
		if(register.getId() != null && register.getId()>0) 
		{
			em.merge(register);
		}
		else 
		{
			em.persist(register);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<ProductRegister> findAllPro() 
	{
		return em.createQuery("from ProductRegister").getResultList();
	}

	public ProductRegister findByIdPro(Long id) {
		return em.find(ProductRegister.class, id);
	}

	public void delete(Long id) {
		data.deleteById(id);
	}

}
