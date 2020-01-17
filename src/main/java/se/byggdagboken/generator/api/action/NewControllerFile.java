package se.byggdagboken.generator.api.action;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import icons.BdbIcons;

public class NewControllerFile extends CreateFileFromTemplateAction {

    private static final String ENTITY_TEMPLATE = "Entity";

    public NewControllerFile() {
        super("API Controller", "Create new API Controller", null);
    }

    @Override
    protected String getActionName(PsiDirectory directory, String name, String template) {
        return "Creating new API Controller";
    }

    @Override
    protected PsiFile createFile(String name, String templateName, PsiDirectory dir) {
        final FileTemplate template = FileTemplateManager.getInstance(dir.getProject()).getInternalTemplate(templateName);
        return createFileFromTemplate(name, template, dir);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
        System.out.println("buildDialog");
        builder
            .setTitle("Api Controller Title")
            //.setValidator(JuliaNameValidator)
            .addKind("Controller", BdbIcons.JULIA_ICON, "Julia File")
            .addKind("Module", BdbIcons.JULIA_MODULE_ICON, "Julia Module")
            .addKind("Type", BdbIcons.JULIA_TYPE_ICON, "Julia Type")
            .addKind("Function", BdbIcons.JULIA_FUNCTION_ICON, "Julia Function");
    }

    @Override
    public boolean startInWriteAction() {
        return false;
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}