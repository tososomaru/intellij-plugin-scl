package com.tososomaru.language.scl;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.tososomaru.language.scl.psi.SCLProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;
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
        return getProperties(project)
                .filter(sclProperty -> key.equals(sclProperty.getKey()))
                .collect(Collectors.toList());
    }

    public static List<SCLProperty> findProperties(Project project) {
        return getProperties(project)
                .collect(Collectors.toList());
    }

    private static Stream<SCLProperty> getProperties(Project project) {
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SCLFileType.INSTANCE, GlobalSearchScope.allScope(project));

        return virtualFiles.stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(Objects::nonNull)
                .map(psiFile -> PsiTreeUtil.getChildrenOfType(psiFile, SCLProperty.class))
                .filter(Objects::nonNull).flatMap(Arrays::stream);
    }

    /**
     * Attempts to collect any comment elements above the Simple key/value pair.
     */
    public static @NotNull String findDocumentationComment(SCLProperty property) {


        return StreamIterator.finite(new PsiElementIterator(property.getPrevSibling()))
                .filter(PsiComment.class::isInstance)
                .map(PsiElement::getText)
                .map(s -> s.replaceFirst("[!# ]+", ""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining("\n"));
    }

}
