package utilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredRequestFilter implements Filter {
    //private static final Log log = LogFactory.getLog(RestAssuredRequestFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        if (response.statusCode() != 200) {
            LoggerLoad.logInfo(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
                    response.getStatusCode() + " " + response.getStatusLine());   
            
        }
        LoggerLoad.logInfo(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() + "\n Response Status => " +
                response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint());
        return response;
    }
	
}
