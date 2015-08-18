package fr.clicandpick.ws;

import com.nimbusds.jose.JOSEException;
import fr.clicandpick.core.Token;
import fr.clicandpick.dao.DAOException;
import fr.clicandpick.dao.DAOFactory;
import fr.clicandpick.dao.UserDAO;
import fr.clicandpick.model.User;
import fr.clicandpick.utils.AuthUtils;
import fr.clicandpick.utils.PasswordService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Marc on 08/08/2015.
 */
@Path("/auth")
public class AuthResource {

    private static final String LOGING_ERROR_MSG = "",
            CONFLICT_MSG = "";

    private UserDAO dao;

    AuthResource() {
        dao = DAOFactory.getInstance().getUserDao();
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@Valid final User user, @Context final HttpServletRequest request) throws JOSEException {
        System.out.println("Login");
        final User foundUser = dao.findByEmail(user.getEmail());
        if (foundUser != null
                && PasswordService.checkPassword(user.getPassword(), foundUser.getPassword())) {
            final Token token = AuthUtils.createToken(request.getRemoteHost(), foundUser.getId());
            return Response.ok().entity(token).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity(LOGING_ERROR_MSG).build();
    }

    @POST
    @Path("signup")
    public Response signup(@Valid final User user, @Context final HttpServletRequest request) throws JOSEException {
        System.out.println("Signup");

        user.setPassword(PasswordService.hashPassword(user.getPassword()));
        try {
            final User savedUser = dao.create(user);
            final Token token = AuthUtils.createToken(request.getRemoteHost(), savedUser.getId());
            return Response.status(Response.Status.CREATED).entity(token).build();
        } catch (DAOException e) {
            return Response.status(Response.Status.CONFLICT).entity(CONFLICT_MSG).build();
        }
    }

}
