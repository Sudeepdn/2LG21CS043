from django.shortcuts import render


# Create your views here.
def student_form(request):
    if request.method == 'post':
        request.post['sname']
        sname = request.Post['sname']
        sclass = request.Post['sclass']
        ssection = request.Post['ssection']
        sgender = request.Post['sgender']
        sdob = request.Post['sdob']

        student.objects.create(snams=name,sclass= sclass,ssection=ssection,sgender=sgender,sdob=sdob)
          
        
    return render(request, 'students/student_form.html')
 