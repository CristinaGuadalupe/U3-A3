package guzmancom.cristina.myapplicationactivity.daos;

import guzmancom.cristina.myapplicationactivity.models.Usuario;

import java.util.HashSet;
import java.util.Set;

public class UsuariosDao {
    Set<Usuario> listaUsuarioDao;

    public UsuariosDao() {
        listaUsuarioDao = new HashSet<>();
    }

    public Set<Usuario> getUsuarios() {
        listaUsuarioDao.add(new Usuario("kary", "123"));
        listaUsuarioDao.add(new Usuario("lala", "1234"));
        listaUsuarioDao.add(new Usuario("tata", "12345"));

        return listaUsuarioDao;
    }

    public boolean usuarioExist(final Usuario usAValidar) {
        listaUsuarioDao = getUsuarios();

        for (Usuario usr : listaUsuarioDao) {
            if (usr.getUsuario().equals(usAValidar.getUsuario()) && usr.getPassword().equals(usAValidar.getPassword()))
                return true;

            }
            return false;
        }
}

