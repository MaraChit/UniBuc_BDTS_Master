from rest_framework import viewsets, status
from rest_framework.decorators import action
from rest_framework.response import Response

from api.serializers import UserSerializer
from api.models import User


class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all().order_by('last_name')
    serializer_class = UserSerializer

    @action(detail=False, methods=['POST'])
    def signup(self, request):
        username = request.data["username"]
        password = request.data["password"]
        first_name = request.data["firstName"]
        last_name = request.data["lastName"]
        user = User.objects.filter(username__exact=username).first()
        if user:
            return Response(status=status.HTTP_406_NOT_ACCEPTABLE)
        User.objects.create(username=username, password=password, first_name=first_name, last_name=last_name)
        return Response(status=status.HTTP_202_ACCEPTED)

    @action(detail=False, methods=['POST'])
    def login(self, request):
        username = request.data["username"]
        password = request.data["password"]
        user = User.objects.filter(username__exact=username, password__exact=password).first()
        if not user:
            return Response(status=status.HTTP_404_NOT_FOUND)
        return Response(status=status.HTTP_202_ACCEPTED)