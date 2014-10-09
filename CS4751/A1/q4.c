/*
Assignment #1
Question #4
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

/*Move front count vertices*/
int fC = 0;
/*Move back count vertices*/
int bC = 0;
/* master count */
int mC = 0;

void init(void)
{
  glClearColor(1.0, 1.0, 1.0, 0.0);
  glMatrixMode(GL_PROJECTION);
  glOrtho(0.0, 400.0, 0.0, 400.0, -1.0, 1.0);
}

void display(void)
{
  glClear (GL_COLOR_BUFFER_BIT);

  /*Draw inchworm*/
  glColor3f (255, 255, 0);
  glBegin(GL_POLYGON);
   glVertex2f(10+fC, 10);
   glVertex2f(70+bC, 10);
   glVertex2f(70+bC, 50);
   glVertex2f(10+fC, 50);
  glEnd();

  /*Draw eye*/
  glColor3f (0, 255, 0);
  glBegin(GL_POLYGON);
   glVertex2f(50+bC, 30);
   glVertex2f(60+bC, 30);
   glVertex2f(60+bC, 40);
   glVertex2f(50+bC, 40);
  glEnd();

  glutSwapBuffers();

  usleep(10000);

  mC++;

  /*move inch worm*/
  if((mC/60)%2 == 0)
  {
    bC++;
  }
  else{
    fC++;
  }

  if((70+fC) <= glutGet(GLUT_WINDOW_WIDTH) ){
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
    fC = 0;
    bC = 0;
    mC = 0;
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
