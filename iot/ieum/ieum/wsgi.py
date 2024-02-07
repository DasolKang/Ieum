"""
WSGI config for ieum project.

It exposes the WSGI callable as a module-level variable named ``application``.

For more information on this file, see
https://docs.djangoproject.com/en/5.0/howto/deployment/wsgi/
"""


import os
import atexit
from django.core.wsgi import get_wsgi_application
from .tasks import scheduler

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'ieum.settings')

application = get_wsgi_application()


# 스케줄링 작업 실행
# 스케줄러가 실행 중인지 확인하고 실행 중이 아닌 경우에만 실행
if not scheduler.running:
    scheduler.start()

# 애플리케이션이 종료될 때 스케줄러 중지
atexit.register(lambda: scheduler.shutdown())
