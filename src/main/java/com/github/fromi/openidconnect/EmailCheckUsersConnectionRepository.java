package com.github.fromi.openidconnect;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.util.MultiValueMap;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;

public class EmailCheckUsersConnectionRepository implements UsersConnectionRepository {


	

	
	@Override
	public List<String> findUserIdsWithConnection(Connection<?> connection) {
		UserProfile userProfile = connection.fetchUserProfile();
		
		return Arrays.asList(userProfile.getEmail());
	}

	@Override
	public Set<String> findUserIdsConnectedTo(String providerId,
			Set<String> providerUserIds) {

		return null;
	}

	@Override
	public ConnectionRepository createConnectionRepository(String userId) {

		return new EmailCheckConnectionRepository();
	}



}
