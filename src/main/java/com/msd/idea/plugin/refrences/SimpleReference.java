package com.msd.idea.plugin.refrences;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import com.msd.idea.plugin.LanguageIcons;
import com.msd.idea.plugin.component.MyProjectComponentImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleReference extends PsiReferenceBase<PsiElement> {

    private PsiElement value;
    private String type;

    public SimpleReference(PsiElement element, String type) {
        super(element);
        this.value = element;
        this.type = type;
    }


    @Nullable
    @Override
    public PsiElement resolve() {
        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return MyProjectComponentImpl.getList().toArray();
    }
}
