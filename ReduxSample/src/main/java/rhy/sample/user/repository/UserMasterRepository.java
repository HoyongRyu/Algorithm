package rhy.sample.user.repository;

import rhy.sample.common.datasource.MasterMapper;
import rhy.sample.user.entity.User;

@MasterMapper
public interface UserMasterRepository {
    public void insert(User user);
}
