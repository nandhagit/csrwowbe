/*
 * package com.wow.wow.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.wow.wow.model.WowUser; import com.wow.wow.model.WowUserDetails;
 * import com.wow.wow.repository.WowUserRepository;
 * 
 * @Service public class WowUserDetailsService implements UserDetailsService{
 * 
 * @Autowired WowUserRepository userrepo;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { WowUser user =
 * userrepo.findByEmail(username).orElse(null); return new WowUserDetails(user);
 * }
 * 
 * }
 */