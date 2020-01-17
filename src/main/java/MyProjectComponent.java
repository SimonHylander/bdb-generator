import com.intellij.openapi.components.ProjectComponent;
import org.jetbrains.annotations.NotNull;

public class MyProjectComponent implements ProjectComponent {

    @Override
    public void projectOpened() {
        System.out.println("projectOpened");
    }

    @Override
    public void projectClosed() {
        System.out.println("projectClosed");
    }

    @Override
    public void initComponent() {
        System.out.println("initComponent");
    }

    @Override
    public void disposeComponent() {
        System.out.println("disposeComponent");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "BDB API Generator";
    }
}