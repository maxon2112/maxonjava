package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {

  @Test
  public void testCreateIssue() throws IOException {
    boolean issueOpen = isIssueOpen(740);
    if (issueOpen == false) {
      skipIfNotFixed(740);
    }
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("test Issue MX").withDescription("new test issue");
    int issueId = create(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }
}
