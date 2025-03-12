from django.urls import path
from .views import student_form

urlpatterns = [
    path('student_form/', student_form, name='student_form'),
]