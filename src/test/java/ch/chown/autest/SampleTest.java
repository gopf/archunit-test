package ch.chown.autest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.freeze.FreezingArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = { "ch.chown" })
public class SampleTest {

    @ArchTest
    public static final ArchRule slices_should_be_free_of_cycles =
            FreezingArchRule.freeze(slices().matching("ch.chown.autest.(*)").should().beFreeOfCycles());

}
