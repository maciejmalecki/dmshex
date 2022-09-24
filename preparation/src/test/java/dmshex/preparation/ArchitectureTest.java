package dmshex.preparation;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;


@AnalyzeClasses(packages = {"dmshex.preparation"})
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule entityCannotImportUseCases = noClasses()
            .that().resideInAPackage("dmshex.preparation")
            .should().dependOnClassesThat().resideInAPackage("dmshex.preparation.usecases..");

}
