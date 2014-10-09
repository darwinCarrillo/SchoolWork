/*
Assignment #1
Question #1
Author: Darwin Carrillo
Student#: 201153210
Code was based off of hello.c by Paul Gillard
*/

#if defined(__APPLE__) || defined(MACOSX)
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif
#include <math.h>
#include <stdio.h>
#include <stdlib.h>

/*Set initial state*/
void init (void)
{
  /*Set clearing to yellow */
   glClearColor (1.0, 1.0, 0.0, 0.0);
   glMatrixMode(GL_PROJECTION);
   glOrtho(0.0, 10.0, 0.0, 10.0, -1.0, 1.0);
}

void display(void)
{
  glClear (GL_COLOR_BUFFER_BIT);
  /*draw triangle at (.3,.3), (.6,.3) (.45, calculated height)*/
  double h = ((sqrt(3)/2)*6);
  /*set trignale color to blue*/
  glColor3f (0.0, 0.0, 1.0);
  glBegin(GL_TRIANGLES);
    glVertex2f (2, 2);
    glVertex2f (8, 2);
    glVertex2f (5, h+2);
  glEnd();
  glFlush ();
}

/*keyboard callback function */
void keyboardCall(signed char key, int x, int y)
{if (key == 81 || key == 113) exit(0);}

/*right click mouse callback function*/
void mouseCall(int btn, int state, int x, int y)
{if(btn==GLUT_RIGHT_BUTTON && state==GLUT_DOWN) exit(0);}

/* Reshape callback function */
void reshape(GLsizei w, GLsizei h)
{
  glViewport (0, 0, w, 400);
}

int main(int argc, char** argv)
{

  glutInit(&argc, argv);
  glutInitDisplayMode (GLUT_SINGLE | GLUT_RGB);
  glutInitWindowSize (400, 400);
  glutInitWindowPosition (100, 100);
  glutCreateWindow ("Triangle");
  init ();
  /* load mouse and keyboard callback fucntion */
  glutKeyboardFunc(keyboardCall);
  glutDisplayFunc(display);
  glutMouseFunc(mouseCall);
  glutReshapeFunc(reshape);
  glutMainLoop();
  return 0;
}
