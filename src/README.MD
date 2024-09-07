# TODO / TASKS
This list is maintained to keep in mind the tasks and enhancements left for the next day, and points that can be revisited again

- [ ] Look up jasypt for password encryption in application.yml  

<hr>

# Learnings
- While using WebFlux dependenxies the AuthenticationManager and such other dependencies do not work and throw a PropertyConfiguration error stemming from ```java.lang.ClassNotFoundException: jakarta.servlet.Filter``` . HEnce the imports had to be changed to Reactive based imports and class implementations.