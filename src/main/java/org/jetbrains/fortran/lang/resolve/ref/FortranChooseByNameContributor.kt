package org.jetbrains.fortran.lang.resolve.ref

import com.intellij.navigation.NavigationItem
import com.intellij.navigation.ChooseByNameContributor
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import org.jetbrains.fortran.lang.core.stubs.index.FortranNamedElementIndex
import org.jetbrains.fortran.lang.psi.ext.FortranNamedElement

class FortranChooseByNameContributor   : ChooseByNameContributor/*, GotoClassContributor*/ {
    private val indexKey = FortranNamedElementIndex.KEY
    private val clazz = FortranNamedElement::class.java

        init {

            System.out.println("FortranChooseByNameContributor Init")
        }
        override fun getNames(project: Project?, includeNonProjectItems: Boolean): Array<out String> {
            project ?: return emptyArray()
            return StubIndex.getInstance().getAllKeys(indexKey, project).toTypedArray()
        }

        override fun getItemsByName(name: String?,
                                    pattern: String?,
                                    project: Project?,
                                    includeNonProjectItems: Boolean): Array<out NavigationItem> {
            if (project == null || name == null) {
                return emptyArray()
            }
            val scope = if (includeNonProjectItems)
                GlobalSearchScope.allScope(project)
            else
                GlobalSearchScope.projectScope(project)

            return StubIndex.getElements(indexKey, name, project, scope, clazz).toTypedArray<NavigationItem>()
        }

      /*  override fun getQualifiedName(item: NavigationItem?): String? = (item as? FortranNamedElement)?.qualifiedName

        override fun getQualifiedNameSeparator(): String = "::"*/
}
