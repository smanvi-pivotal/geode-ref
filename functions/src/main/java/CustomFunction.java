import com.gemstone.gemfire.cache.execute.FunctionAdapter;
import com.gemstone.gemfire.cache.execute.FunctionContext;

/**
 * Created by smanvi on 7/19/16.
 */
public class CustomFunction  extends FunctionAdapter
{
    @Override
    public void execute(FunctionContext functionContext) {

        System.out.println(" CUSTOMMMMMMMMM");
        while(true){
            System.out.println("$$$$$$$$$$$$ RUNNING FUNCTION " +"CustomFunction");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getId() {
        return "CustomFunction";
    }
}
