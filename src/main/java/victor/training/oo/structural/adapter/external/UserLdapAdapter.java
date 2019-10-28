package victor.training.oo.structural.adapter.external;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import victor.training.oo.structural.adapter.domain.IUserLdapAdapter;
import victor.training.oo.structural.adapter.domain.User;

/// === linie linie linie linie linie linie linie linie linie linie linie linie linie linie linie
// gunoi
@Service
public class UserLdapAdapter implements IUserLdapAdapter {
	@Autowired
	private LdapUserWebserviceClient wsClient;
	@Override
	public List<User> searchByUsername(String username) {
		return wsClient.search(username.toUpperCase(), null, null).stream()
				.map(this::toUser)
				.collect(toList());
	}

	private User toUser(LdapUser ldapUser) {
		String fullName = getFullName(ldapUser);
		return new User(ldapUser.getuId(), fullName, ldapUser.getWorkEmail());
	}
	private String getFullName(LdapUser ldapUser) {
		return ldapUser.getfName() + " " + ldapUser.getlName().toUpperCase();
	}
}