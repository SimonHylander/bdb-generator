package se.byggdagboken.generator.api.action;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;

public class CreateEntityPackage extends CreateFileFromTemplateAction {

    private static final String ENTITY_TEMPLATE = "Entity";

    public CreateEntityPackage() {
        super("Entity Package", "Create new entity package", null);
    }

    @Override
    protected String getActionName(PsiDirectory directory, String name, String template) {
        return "Creating new entity package";
    }

    @Override
    protected PsiFile createFile(String name, String templateName, PsiDirectory dir) {

        final FileTemplate template = FileTemplateManager.getInstance(dir.getProject()).getInternalTemplate(templateName);
        return createFileFromTemplate(name, template, dir);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle("Entity package");
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