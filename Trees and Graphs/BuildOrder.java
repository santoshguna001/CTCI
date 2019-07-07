
/**
 * You are given a list of projects and a list of dependencies (which is a list
 * of pairs of projects, where the second project is dependent on the fist
 * project). All ofa project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built. If there is no
 * valid build order, return an error.
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 */
import java.util.Iterator;
import java.util.LinkedList;

class BuildOrder {
    static class Project {
        char project;
        LinkedList<Project> list;

        Project(char project) {
            this.project = project;
            list = new LinkedList<Project>();
        }

        Project(char project, LinkedList<Project> list) {
            this.project = project;
            this.list = list;
        }
    }

    public static Project addDependencies(LinkedList<Project> projectList, char a, char b) {
        Project first = getProject(a, projectList), second = getProject(b, projectList);
        if (projectList.contains(first)) {
            if (projectList.contains(second)) {
                second.list.add(first);
                return second;
            }
            System.out.println("No dependent project found");
        }
        System.out.println("No base project found");
        return null;
    }

    public static Project getProject(char c, LinkedList<Project> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).project == c) {
                return list.get(i);
            }
        }
        return null;
    }

    public static LinkedList<Project> buildOrder(LinkedList<Project> projectList, LinkedList<Project> done) {
        int count = 0, added = 0;
        if (projectList.size() == 0) {
            return done;
        }
        if (done == null) {
            done = new LinkedList<Project>();
        }
        while (count < projectList.size()) {
            Project temp = projectList.get(count);
            if (temp.list.size() == 0) {
                done.add(temp);
                projectList.remove(temp);
                added++;
                count--;
            }
            count++;
        }
        count = 0;
        while (count < projectList.size()) {
            Project temp = projectList.get(count);
            int done_count = 0;
            while (done_count < done.size()) {
                if (temp.list.contains(done.get(done_count))) {
                    temp.list.remove(done.get(done_count));
                    added++;
                    count--;
                }
                done_count++;
            }
            count++;
        }
        if (added == 0) {
            return null;
        }
        buildOrder(projectList, done);
        return done;
    }

    public static void main(String[] args) {
        LinkedList<Project> projectList = new LinkedList<Project>();
        // Adding the projects
        projectList.add(new Project('a'));
        projectList.add(new Project('b'));
        projectList.add(new Project('c'));
        projectList.add(new Project('d'));
        projectList.add(new Project('e'));
        projectList.add(new Project('f'));
        int projectListSize = projectList.size();

        // Adding the dependencies
        addDependencies(projectList, 'a', 'd');
        addDependencies(projectList, 'f', 'b');
        addDependencies(projectList, 'b', 'd');
        addDependencies(projectList, 'f', 'a');
        addDependencies(projectList, 'd', 'c');

        LinkedList<Project> done = buildOrder(projectList, null);
        if (done.size() != projectListSize) {
            System.out.println("null");
            return;
        }
        done.forEach(S -> System.out.println(S.project));
    }
}