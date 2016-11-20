package ge.mziuri.gll.dao;

import ge.mziuri.gll.model.User;

public interface StudentDAO {

    public void AddStudent(User u);

    public void RemoveStudent(User u);

    public User GetStudent(String indentification);

}
