package com.tososomaru.language.scl;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.tososomaru.language.scl.psi.SCLFile;
import com.tososomaru.language.scl.psi.SCLProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SCLUtil {

    /**
     * Searches the entire project for Simple language files with instances of the Simple property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<SCLProperty> findProperties(Project project, String key) {
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SCLFileType.INSTANCE, GlobalSearchScope.allScope(project));

        return virtualFiles.stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(Objects::nonNull)
                .map(psiFile -> PsiTreeUtil.getChildrenOfType(psiFile, SCLProperty.class))
                .filter(Objects::nonNull)
                .flatMap(sclProperties -> Arrays.stream(sclProperties).
                        filter(sclProperty -> key.equals(sclProperty.getKey())))
                .collect(Collectors.toList());
    }

    public static List<SCLProperty> findProperties(Project project) {

        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SCLFileType.INSTANCE, GlobalSearchScope.allScope(project));

        return virtualFiles.stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(Objects::nonNull)
                .map(psiFile -> PsiTreeUtil.getChildrenOfType(psiFile, SCLProperty.class))
                .filter(Objects::nonNull)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    /**
     * Attempts to collect any comment elements above the Simple key/value pair.
     */
    public static @NotNull String findDocumentationComment(SCLProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result),"\n ");
    }

}
