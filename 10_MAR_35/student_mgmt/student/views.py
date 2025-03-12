from django.shortcuts import render

# Create your views here.
def student_form(request):
    return render(request, 'students/student_form.html')