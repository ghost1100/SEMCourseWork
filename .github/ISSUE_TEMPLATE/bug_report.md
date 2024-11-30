---
name: Bug report
about: a Bug report to help us improve
title: Misplet words 
labels: Password Missmatch
assignees: Rachel, Erin.

---

**Describe the bug**
the database password did not match when called and when initisalised onto the docker compose.

**To Reproduce**
Steps to reproduce the behavior:
1. Go to docker compose, change the password
2. Click on run docker compose
3. Scroll to database config, run app.
4. See error... database not connecting.

**Expected behavior**
if there is a password missmatch the database would not run as expected and a few errors would rise up.
this only applies to mysql version 8.3 or older reason being the latest version of my sql does not require a password.

**Screenshots**
![image](https://github.com/user-attachments/assets/6c0b645c-e155-4382-b3c3-7e5a9110cf06)

![image](https://github.com/user-attachments/assets/5df28577-55dc-49f8-9e7d-1104e9ee2588)


**Desktop (please complete the following information):**
 - OS: [Windows 11]
 - Browser [Brave]
 - Version [v1.73.91 (Nov 20, 2024)]


**Additional context**
the issue can be replicated by changing the databse config password accidentally or on an older version of my sql adding in a wrong password
