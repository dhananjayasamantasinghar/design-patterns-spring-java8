package victor.training.oo.structural.adapter.domain;

import java.util.List;

public interface IUserLdapAdapter {

	List<User> searchByUsername(String username);

}