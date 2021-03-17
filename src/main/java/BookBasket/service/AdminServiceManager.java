package BookBasket.service;

import BookBasket.Repo.AdminRepo;
import BookBasket.Repo.AdminRepoManager;
import BookBasket.model.Admin;

public class AdminServiceManager implements AdminService {
	private AdminRepo adminRepo;
	
	public AdminServiceManager() {
		this.adminRepo=new AdminRepoManager();
	}
	@Override
	public Boolean addAdmin(Admin admin) {
		adminRepo.add(admin);
		return true;
	}

	@Override
	public Boolean loginAdmin(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
