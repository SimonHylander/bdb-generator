package se.byggdagboken.generator.api.action;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import icons.BdbIcons;

public class CreateApi extends CreateFileFromTemplateAction {

    private static final String ENTITY_TEMPLATE = "Entity";

    public CreateApi() {
        super("BDB API", "Create new BDB API", null);
    }

    @Override
    protected String getActionName(PsiDirectory directory, String name, String template) {
        System.out.println("getActionName");
        System.out.println(name);
        System.out.println(template);
        return "Creating new BDB API";
    }

    @Override
    protected PsiFile createFile(String name, String templateName, PsiDirectory dir) {
        System.out.println("createFile");
        final FileTemplate template = FileTemplateManager.getInstance(dir.getProject()).getInternalTemplate(templateName);
        return createFileFromTemplate(name, template, dir);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
        System.out.println("build api dialog!");

        builder
            .setTitle("BDB Api")
            //.setValidator(JuliaNameValidator)
            .addKind("Entity", BdbIcons.JULIA_MODULE_ICON, "Entity")
            .addKind("Controller", BdbIcons.JULIA_ICON, "Controller")
            .addKind("Service", BdbIcons.JULIA_ICON, "Service")
            .addKind("Repository", BdbIcons.JULIA_ICON, "Repository")
            .addKind("Model", BdbIcons.JULIA_MODULE_ICON, "Model")
            .addKind("ModelAssembler", BdbIcons.JULIA_FUNCTION_ICON, "ModelAssembler");
    }

    @Override
    public boolean startInWriteAction() {
        System.out.println("startInWriteAction");
        return false;
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}