/*
Assignment #1
Question #1
Author: Darwin Carrillo
Student#: 201153210
Code was based off of mercury.c by Paul Gillard
*/

#if defined(__APPLE__) || defined(MACOSX)
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <errno.h>

int lC = 0;

void init(void)
{
  glClearColor(1.0, 1.0, 1.0, 0.0);
  glMatrixMode(GL_PROJECTION);
  glOrtho(0.0, 400.0, 0.0, 400.0, -1.0, 1.0);
}

void display(void)
{
  glClear (GL_COLOR_BUFFER_BIT);
  glColor3i (rand(), rand(), rand());

  glBegin(GL_POLYGON);
   glVertex2f(10+lC, 10);
   glVertex2f(30+lC, 10);
   glVertex2f(30+lC, 30);
   glVertex2f(10+lC, 30);
  glEnd();

  glutSwapBuffers();

  usleep(10000);

  lC++;

  if((30+lC) <= glutGet(GLUT_WINDOW_WIDTH) ){
    glutPostRedisplay();
  }
  else{
    printf("edge");
  }
}

/*right click mouse callback function*/
void mouseCall(int btn, int state, int x, int y)
{
  if(btn==GLUT_RIGHT_BUTTON && state==GLUT_DOWN)
    exit(0);
  if(btn==GLUT_LEFT_BUTTON && state==GLUT_DOWN)
  {
    lC = 0;
  }
}

/* Resize window */
void resizeCall(GLsizei w, GLsizei h){
  glViewport (0, 0, (GLsizei) w, (GLsizei) h);
  glMatrixMode (GL_PROJECTION);
  glLoadIdentity ();

  glOrtho(0.0, (GLfloat)w, 0.0, (GLfloat)h, -1.0, 1.0);
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
}

int main(int argc, char** argv)
{
   glutInit(&argc, argv);
   glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB);
   glutInitWindowSize (400, 400);
   glutInitWindowPosition (100, 100);
   glutCreateWindow (argv[0]);
   init ();
   glutDisplayFunc(display);
   glutReshapeFunc(resizeCall);
   glutMouseFunc(mouseCall);
   glutMainLoop();
   return 0;
}
